import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';
const authors = (props) => {
    return ( <
        div className = { "container mm-4 mt-5" } >
        <
        div className = { "row" } >
        <
        div className = { "table-responsive" } >
        <
        table className = { "table table-striped" } >
        <
        thead >
        <
        tr >
        <
        th scope = { "col" } > Name < /th> <
        th scope = { "col" } > Address < /th> <
        /tr> <
        /thead> <
        tbody > {
            props.author.map((term) => {
                return ( <
                    tr >
                    <
                    td > { term.author_name } < /td> <
                    td > { term.author_surname } < /td> <
                    /tr>
                );
            })
        } <
        /tbody> <
        /table> <
        /div> <
        /div> <
        /div>
    );
}

export default authors;