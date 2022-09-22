import './App.css';
import React, { Component } from "react";
import Authors from '../Authors/Authors';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import EShopService from "../../repository/eshopRepository";
import Header from "../Header/Header";
import Login from "../Login/Login";
import Products from "../Books/productTerm";
import 'bootstrap/dist/css/bootstrap.min.css';
import ProductAdd from '../Books/productAdd';
class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            author: [],
            products: []
        }
    }

    render() {
            return ( <
                    Router >
                    <
                    Header / >
                    <
                    main >
                    <
                    div className = "container" >
                    <
                    Routes >

                    <
                    Route path = { "/authors" }
                    exact element = { < Authors author = { this.state.author }
                        />}/ >
                        <
                        Route path = { "/products" }
                        exact element = { < Products products = { this.state.products }
                            onDelete = { this.deleteProduct }
                            />}/ >
                            <
                            Route path = { "/login" }
                            exact element = { < Login onLogin = { this.fetchData }
                                />}/ >


                                <
                                Route path = { "/products/add" }
                                exact element = { <
                                    ProductAdd author = { this.state.author }
                                    onAddProduct = { this.addProduct }
                                    />}/ >


                                    <
                                    /Routes> <
                                    /div>

                                    <
                                    /main> <
                                    /Router>
                                );

                            }
                            componentDidMount() {
                                this.fetchData()
                            }

                            fetchData = () => {
                                this.loadAuthor();
                                this.loadProducts();
                            }

                            loadAuthor = () => {
                                EShopService.fetchAuthors()
                                    .then((data) => {
                                        this.setState({
                                            author: data.data
                                        })
                                    });
                            }

                            deleteProduct = (id) => {
                                EShopService.deleteProduct(id)
                                    .then(() => {
                                        this.loadProducts();
                                    });
                            }

                            addProduct = (id, name, year, author) => {
                                EShopService.addProduct(id, name, year, author)
                                    .then(() => {
                                        this.loadProducts();
                                    });
                            }



                            loadProducts = () => {
                                EShopService.fetchProducts()
                                    .then((data) => {
                                        this.setState({
                                            products: data.data
                                        })
                                    });
                            }

                        }

                        export default App;