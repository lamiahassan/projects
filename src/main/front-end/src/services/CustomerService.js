import axios from "axios";

class CustomerService {

    getCustomers() {
        return axios.get("http://localhost:8080/International-Phone-Number/customerData/allPages?pageNo=0&pageSize=20");
    }
}

export default new CustomerService()