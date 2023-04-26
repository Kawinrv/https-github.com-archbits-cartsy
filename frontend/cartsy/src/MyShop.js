import React from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { useState } from 'react';

const MyShop = () => {

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
            </div>


            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>New Product</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <div className='form-group'>

                        <select name="category" type="text" className='form-control mt-1' ></select>
                        <input name="productName" type="text" className='form-control mt-1' placeholder="Name"></input>
                        <input name="productSDesc" type="text" className='form-control mt-1' placeholder="Short Description"></input>
                        <textarea name="productLDesc" type="text" className='form-control mt-1' placeholder="Long Description"></textarea>
                        <input name="price" type="text" className='form-control mt-1' placeholder="Price"></input>
                        <input name="quantity" type="text" className='form-control mt-1' placeholder="Quantity"></input>
                        <input name="brand" type="text" className='form-control mt-1' placeholder="Brand"></input>
                        <select name="color" type="text" className='form-control mt-1' placeholder="Color"></select>

                    </div>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleClose}>
                        Save Changes
                    </Button>
                </Modal.Footer>
            </Modal>
        </div>
    );

}

export default MyShop;