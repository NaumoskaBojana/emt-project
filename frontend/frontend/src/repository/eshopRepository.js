import axios from '../custom-axios/axios';

const EShopService = {

    fetchProducts: () => {
        return axios.get("/products");
    },
    getProduct: (id) => {
        return axios.get(`/products/${id}`);
    },
    deleteProduct: (id) => {
        return axios.delete(`/products/delete/${id}`);
    },
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    login: (user_username, user_password) => {
        return axios.post("/login", {
            "user_username": user_username,
            "user_password": user_password
        });
    },

    addProduct: (id, name, year, author) => {
        return axios.post("/products/add", {
            "id": id,
            "name": name,
            "year": year,
            "author": author
        });
    }


}

export default EShopService;