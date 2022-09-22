import React from 'react';
import { Link } from 'react-router-dom';

const header = (props) => {
        let authenticate
        if (localStorage.getItem("JWT")) {
            authenticate = ( < button className = "btn btn-outline-info my-2 my-sm-0"
                onClick = {
                    () => localStorage.removeItem("JWT") } > Logout < /button>);
            }
            else {
                authenticate = ( < Link className = "btn btn-outline-info my-2 my-sm-0"
                    to = { "/login" } > Login < /Link>);
                }

                return ( <
                    header >
                    <
                    nav className = "navbar navbar-expand-lg navbar-light bg-light" >
                    <
                    div className = "container" >
                    <
                    a className = "navbar-brand"
                    href = "/" > ESHOP - Application < /a>

                    <
                    ul className = "navbar-nav" >
                    <
                    li className = "nav-item active" >
                    <
                    Link className = "nav-link"
                    to = { "/authors" } > Authors < /Link> <
                    /li> <
                    li className = "nav-item active" >
                    <
                    Link className = "nav-link"
                    to = { "/products" } > Products < /Link> <
                    /li>

                    <
                    form className = "form-inline mt-2 mt-md-0 ml-3" > { authenticate } <
                    /form>


                    <
                    /ul> <
                    /div> <
                    /nav> <
                    /header>
                )
            }

            export default header;