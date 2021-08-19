
import React from "react";
import { useTable, useEffect, useState } from 'react-table'
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from "axios";


function BasicTableComponent() {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios("http://localhost:8080/International-Phone-Number/customerData/allPages?pageNo=0&pageSize=5")
            .then((res) => {
                setData(res.data)
                // .map(function (customer) {
                //     <div>
                //         <div>{customer.custId}</div>
                //         <div>{customer.phoneNo}</div>
                //         <div>{customer.country}</div>
                //         <div>{customer.state}</div>
                //     </div>
                // })
            })
            .catch((err) => console.log(err))
    }, []);

    const columns = [
        {
            Header: 'Customer',
            columns: [
                {
                    Header: 'Customer ID',
                    accessor: 'custId',
                }
            ],
        },
        {
            Header: 'Info',
            columns: [
                {
                    Header: 'Customer Phone',
                    accessor: 'phoneNo',
                },
                {
                    Header: 'Country',
                    accessor: 'country',
                },
                {
                    Header: 'Phone State',
                    accessor: 'state',
                }
            ],
        },
    ];

    const {
        getTableProps,
        getTableBodyProps,
        headerGroups,
        rows,
        prepareRow,
    } = useTable({
        columns,
        data,
    })


    return (

        <table className="table" {...getTableProps()}>
            <thead>
                {headerGroups.map(headerGroup => (
                    <tr {...headerGroup.getHeaderGroupProps()}>
                        {headerGroup.headers.map(column => (
                            <th {...column.getHeaderProps()}>{column.render('Header')}</th>
                        ))}
                    </tr>
                ))}
            </thead>
            <tbody {...getTableBodyProps()}>
                {rows.map((row, i) => {
                    prepareRow(row)
                    return (
                        <tr {...row.getRowProps()}>
                            {row.cells.map(cell => {
                                return <td {...cell.getCellProps()}>{cell.render('Cell')}</td>
                            })}
                        </tr>
                    )
                })}
            </tbody>
        </table>
    )
}

export default BasicTableComponent;