import React, { useEffect, useState } from "react";

import $ from 'jquery';
import "../node_modules/jquery/dist/jquery.min.js";
import Carousel from 'react-bootstrap/Carousel';
import Modal from 'react-bootstrap/Modal';
import "../node_modules/bootstrap-table/dist/bootstrap-table.min.css";
import "../node_modules/bootstrap-table/dist/bootstrap-table.min.js";




const Cart = () => {


    var [cart, setCart] = useState({products:""});
    var [products, setProducts] = useState([]);
    
    
    function loadCart() {
        const url = "http://localhost:8080/api/v1/private/buyers/cart/" + localStorage.getItem("id");

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Accept", "application/json");

        myHeaders.append("Authorization", "Bearer " + localStorage.getItem("jwt"));

        var requestOptions = {
            method: 'GET',
            headers: myHeaders,

        };

        fetch(url, requestOptions)
            .then(response => {
                if (response.status === 200) {

                    response.json().then((data) => {
                        setCart(data);
                        loadProducts(data);
                    });


                } else {

                }
            })
            .catch(error => { console.log('error', error) });
    }

    function loadProducts(cart) {

        if (cart != undefined && cart.products != undefined) {

            let productIds = cart.products.split(",");
            let productList = [];

            productIds.forEach(element => {



                const url = "http://localhost:8080/api/v1/public/products/" + element;

                var myHeaders = new Headers();
                myHeaders.append("Content-Type", "application/json");
                myHeaders.append("Accept", "application/json");

                myHeaders.append("Authorization", "Bearer " + localStorage.getItem("jwt"));

                var requestOptions = {
                    method: 'GET',
                    headers: myHeaders,

                };

                fetch(url, requestOptions)
                    .then(response => {
                        if (response.status === 200) {

                            response.json().then((data) => {
                                productList.push(data);
                                setProducts(productList);

                                if(productList.length==productIds.length)
                                    $('#table').bootstrapTable({
                                        pagination: true,
                                        search: true,
                                        sort: true,
                                        columns: [ {
                                          field: 'productName',
                                          title: 'Name',
                                          sortable: true,
                                        }, 
                                        {
                                            field: 'productSDesc',
                                            title: 'Description',
                                            sortable: true
                                          },{
                                          field: 'productActualPrice',
                                          title: 'Original Price',
                                          sortable: true
                                        },{
                                            field: 'productSalePrice',
                                            title: 'Price',
                                            sortable: true
                                          }

                                        ],
                                        data: productList
                                      });
                                
                                
                            });


                        } else {

                        }
                    })
                    .catch(error => { console.log('error', error) });

            });

        }

    }

    

    useEffect(() => {
        loadCart();
        
    }, []);

    

    return (<div className="container">
        <br />
        <div className="row">  
        <div className="float-end"> 
            <div className="btn-group">
                <a className="btn btn-success" href="/checkout">Checkout</a>
                <button className="btn btn-warning">Clear</button>
            </div>
        </div>
        </div>

        
        <div className="row">  

        <table id="table"></table>
        

     </div>

    </div>);
}

export default Cart;