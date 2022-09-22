import React from 'react';
import { useNavigate } from 'react-router-dom';
import EShopService from "../../repository/eshopRepository";
import 'bootstrap/dist/css/bootstrap.min.css';
const Login = (props) => {

    const history = useNavigate();
    const [formData, updateFormData] = React.useState({
        user_username: "",
        user_password: ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        EShopService.login(formData.user_username, formData.user_password).then(resp => {
            localStorage.setItem("JWT", resp.data);
            props.onLogin()
            history.push("/products");
        })

    }

    return ( <
        div className = "row mt-5" >
        <
        div className = "col-md-5" >
        <
        form onSubmit = { onFormSubmit } >
        <
        div className = "form-group" >
        <
        label htmlFor = "user_username" > Username < /label> <
        input type = "text"
        className = "form-control"
        name = "user_username"
        required placeholder = "Enter username"
        onChange = { handleChange }
        /> <
        /div> <
        div className = "form-group" >
        <
        label htmlFor = "user_password" > Password < /label> <
        input type = "password"
        className = "form-control"
        name = "user_password"
        placeholder = "Enter password"
        required onChange = { handleChange }
        /> <
        /div> <
        button id = "submit"
        type = "submit"
        className = "btn btn-primary" > Submit < /button> <
        /form> <
        /div> <
        /div>
    )
}

export default Login;