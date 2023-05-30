import React, { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import Carousel from 'react-bootstrap/Carousel';
import Modal from 'react-bootstrap/Modal';




const Product = () => {

    var [categories, setCategories] = useState(categories);

    var [product, setProduct] = useState({});
    const [searchParams, setSearchParams] = useSearchParams();

    const id = searchParams.get("id");

    const [show, setShow] = useState(false);


    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const addToCart = (e) => {
        e.preventDefault();

        


        const url = "http://localhost:8080/api/v1/private/buyers/cart/"+localStorage.getItem("id")+"?productId="+product.id;

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Accept", "application/json");
        myHeaders.append("Authorization", "Bearer " + localStorage.getItem("jwt"));


        var raw = JSON.stringify(
            product
        );

        console.log(raw);

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw
        };

        fetch(url, requestOptions)
            .then(response => {

                if (response.status === 200) {
                    loadProduct();
                    response.json().then(data => {
                        console.log(data);
                        
                    })

                } else {

                }

            })
            .catch(error => { console.log('error', error) });

    }

    function saveProductImages(e, id) {
        const baseurl = "http://localhost:8080/api/v1/private/products/" + id + "/images/";

        for (let i = 1; i <= 4; i++) {

            if (e.target.elements["image_" + i].files[0] != undefined) {
                console.log("saving file..." + i);
                let url = baseurl + i;
                const formData = new FormData();
                formData.append("file", e.target.elements["image_" + i].files[0]);

                var myHeaders = new Headers();
                myHeaders.append("Authorization", "Bearer " + localStorage.getItem("jwt"));

                var requestOptions = {
                    method: 'POST',
                    headers: myHeaders,
                    body: formData
                };

                fetch(url, requestOptions)
                    .then(response => {

                        if (response.status === 200) {
                            console.log("saved image... " + i);

                        } else {
                            console.log("failed to save image... " + i);
                        }

                    })
                    .catch(error => { console.log('error', error) });
            }

        }

    }


    function loadCategories() {
        const url = "http://localhost:8080/api/v1/private/categories";

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
                        setCategories(data);
                    });


                } else {

                }
            })
            .catch(error => { console.log('error', error) });
    }


    function handleChange(e){
        let productUpdate = product;
        console.log(e.target.name +":"+ e.target.value);  
        productUpdate[e.target.name] = e.target.value;
        console.log(JSON.stringify(productUpdate))
        setProduct(productUpdate);
    }
    function loadProduct() {
        const url = "http://localhost:8080/api/v1/public/products/" + id;

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
                        setProduct(data);
                    });


                } else {

                }
            })
            .catch(error => { console.log('error', error) });
    }

    useEffect(() => {
        loadProduct();
        loadCategories();
    }, []);

    function resolveCategory(categoryId) {
        if (categories != undefined && categoryId != undefined && categoryId !== "") {

            categories.forEach(element => {
                if (element.id == categoryId) {

                    return (element.levels);
                }
            });
        }
    }
    return (<div className="container">

        <nav aria-label="breadcrumb">
            <ol className="breadcrumb">
                <li className="breadcrumb-item"><a href="/">Home</a></li>
                <li className="breadcrumb-item"><a href="/search">Search</a></li>
                <li className="breadcrumb-item active" aria-current="page">{product != undefined ? resolveCategory(product.categoryId) : ""}</li>
            </ol>
        </nav>
        <div className="float-end">
            <div className="btn-group">
            <button className="btn btn-success">Buy</button>
            <button className="btn btn-warning" onClick={addToCart}>Add To Cart</button>
            </div>
        </div>

        <div className="row">
            <div className="col-md-4">
                <Carousel className="Custom-carousel">
                    <Carousel.Item>
                        <img
                            className="Custom-carousel"
                            src={"http://localhost:8080/api/v1/public/products/" + id + "/images/1"}
                            alt="Front"
                        />
                        <Carousel.Caption>
                            <h3>Front</h3>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="Custom-carousel"
                            src={"http://localhost:8080/api/v1/public/products/" + id + "/images/2"}
                            alt="Left"
                        />
                        <Carousel.Caption>
                            <h3>Left</h3>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="Custom-carousel"
                            src={"http://localhost:8080/api/v1/public/products/" + id + "/images/3"}
                            alt="Right"
                        />
                        <Carousel.Caption>
                            <h3>Right</h3>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="Custom-carousel"
                            src={"http://localhost:8080/api/v1/public/products/" + id + "/images/4"}
                            alt="Top"
                        />
                        <Carousel.Caption>
                            <h3>Top</h3>
                        </Carousel.Caption>
                    </Carousel.Item></Carousel>
            </div>
            <div className="col-md-8">
            <h3>{product != undefined ? product.productName : ""}</h3>

                <p>{product.productSDesc}</p>
                <p>{product.productLDesc}</p>
                <p>Actual Price: {product.productActualPrice}</p>
                <p>Sale Price: {product.productSalePrice}</p>
                <p>Brand: {product.brand}</p>
            </div>
        </div>
        <br/>
        <div className="row">
            <div className="container"><h2>Reviews</h2></div>
            
        </div>

        
    </div>);
}

export default Product;