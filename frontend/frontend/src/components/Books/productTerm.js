import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const productTerm = (props) => {
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
        th scope = { "col" } > Year < /th> <
        th scope = { "col" } > Author < /th> <
        /tr> <
        /thead> <
        tbody > {
            props.products.map((term) => {
                return ( <
                    tr >
                    <
                    td > { term.book_name } < /td> <
                    td > { term.book_year } < /td> <
                    td > { term.author.author_name } < /td> <
                    td className = { "text-right" } >
                    <
                    a title = { "Delete" }
                    className = { "btn btn-danger" }
                    onClick = {
                        () => props.onDelete(props.term.id) } >
                    Delete <
                    /a> <
                    /td> <
                    /tr>
                );
            })
        } <
        /tbody> <
        /table> <
        /div> <
        div class = "col mb-3" >
        <
        div class = "row" >
        <
        div class = "col-sm-12 col-md-12" >
        <
        a href = "products/add"
        class = "btn btn-block btn-dark add-product-btn" >
        Add new product <
        /a> <
        /div> <
        /div> <
        /div> <
        /div> <
        /div>
    );
}

export default productTerm;