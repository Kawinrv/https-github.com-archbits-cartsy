import React from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { useState, useEffect } from 'react';

const MyShop = () => {

    var [categories, setCategories] = useState(undefined);
    var [products, setProducts] = useState(undefined);
    
    const saveProduct = (e) => {
        e.preventDefault();
        
        const newProduct = {};

        newProduct['sellerId'] = localStorage.getItem("id");
        newProduct['categoryId'] = e.target.elements.categoryId.value;
        newProduct['productName'] = e.target.elements.productName.value;
        newProduct['productSDesc'] = e.target.elements.productSDesc.value;
        newProduct['productLDesc'] = e.target.elements.productLDesc.value;
        newProduct['price'] = e.target.elements.price.value;
        newProduct['quantity'] = e.target.elements.quantity.value;
        newProduct['brand'] = e.target.elements.brand.value;
        
    
        const url = "http://localhost:8080/api/v1/private/products";
    
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Accept", "application/json");
        myHeaders.append("Authorization", "Bearer " + localStorage.getItem("jwt"));

    
        var raw = JSON.stringify(
            newProduct
        );
    
        console.log(raw);
    
         var requestOptions = {
             method: 'POST',
             headers: myHeaders,
             body: raw
         };
    
         fetch(url, requestOptions)
             .then(response => {
                
                if(response.status===200){
                    loadProducts();
                    
                }else{
                    
                }
                
            })
             .catch(error => {console.log('error', error)});
        
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


    function loadProducts() {
        const url = "http://localhost:8080/api/v1/public/products/seller/" + localStorage.getItem("id");

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
                        setProducts(data);
                    });


                } else {

                }
            })
            .catch(error => { console.log('error', error) });
    }

    useEffect(() => {
        loadCategories();
        loadProducts();
    }, []);




    const [show, setShow] = useState(false);


    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return (
        <div>
            <div className="container">
                <br />
                <Button variant="primary" onClick={handleShow}>
                    Add Product
                </Button>
                <br/>
                <div className="container">
                <br/>
                        
                    {
                        products!==undefined ? products.map(item => {
                                return (
                                    <div className="row">

                                    <div  className="col-sm">
                                    <div key={item.id} className="card w-100" >
                                        <div className="card-body">
                                            <h5 className="card-title">{item.productName}</h5>
                                            <p className="card-text">{item.productSDesc}</p>
                                            <a href="#" className="btn btn-primary">Details</a>
                                        </div>
                                    </div>
                                    </div>
                                    </div>

                                );
                            }):""
                    }

                        
                </div>

            </div>


            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>New Product</Modal.Title>
                </Modal.Header>
                <form onSubmit={saveProduct}>

                    <Modal.Body>
                        <div className='form-group'>

                            <select name="categoryId" type="text" className='form-control mt-1' >
                                {
                                    categories != undefined ? categories.map(item => {
                                        return (<option value={item.id}>{item.levels}</option>);
                                    }) : ""
                                }
                            </select>
                            <input name="productName" type="text" className='form-control mt-1' placeholder="Name"></input>
                            <input name="productSDesc" type="text" className='form-control mt-1' placeholder="Short Description"></input>
                            <textarea name="productLDesc" type="text" className='form-control mt-1' placeholder="Long Description"></textarea>
                            <input name="price" type="text" className='form-control mt-1' placeholder="Price"></input>
                            <input name="quantity" type="text" className='form-control mt-1' placeholder="Quantity"></input>
                            <input name="brand" type="text" className='form-control mt-1' placeholder="Brand"></input>


                        </div>
                    </Modal.Body>
                    <Modal.Footer>
                        
                        <button className="btn btn-primary" onClick={handleClose}>
                            Save Changes
                        </button>
                    </Modal.Footer>
                </form>
            </Modal>
        </div>
    );

}

export default MyShop;