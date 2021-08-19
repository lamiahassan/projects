import React, { useState, useEffect } from 'react';
import customerService from '../services/CustomerService';
import "bootstrap/dist/css/bootstrap.css";
import { TextField } from '@material-ui/core'
//import PaginationFactory from 'react-bootstrap-table2-paginator';
//import 'react-bootstrap-table2-paginator/dist/react-bootstrap-table2-paginator.min.css';
//import filterFactory,{textFilter} from 'react-bootstrap-table2-filter';
//import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'



class CustomerComponent extends React.Component {


    constructor(props) {
        super(props)
        this.state = {
            customers: []
        }
    }

    componentDidMount() {
        customerService.getCustomers().then((response) => {
            this.setState({
                customers: response.data
            })
        });
    }

    changeState(state) {
        if (state)
            return "valid"
        return "Not valid"

    }

    render() {

        return (
            <div>
                <h1 className="text-center">International Phone Validation</h1>
                <div>&nbsp;</div>
                <div>&nbsp;</div>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>Customer ID</td>
                            <td >Customer Phone</td>
                            <td> Country</td>
                            <td> Phone State</td>

                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.customers.map
                                (
                                    customer =>
                                        <tr>
                                            <td>{customer.custId}</td>
                                            <td>{customer.phoneNo}</td>
                                            <td>{customer.country}</td>
                                            <td>{this.changeState(customer.state)}</td>
                                        </tr>
                                )
                        }
                    </tbody>

                </table>
            </div>
        )
    }
}
export default CustomerComponent