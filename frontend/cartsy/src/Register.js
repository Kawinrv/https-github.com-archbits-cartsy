import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from "react-router-dom";

const Register = () => {
    const navigate = useNavigate();

    const register = (e) => {
        e.preventDefault();

        const newUser = {};

        newUser['username'] = e.target.elements.username.value;
        newUser['email'] = e.target.elements.email.value;
        newUser['type'] = e.target.elements.role.value;
        newUser['password'] = e.target.elements.password.value;

        const url = "http://localhost:8080/api/v1/public/register";

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Accept", "application/json");

        var raw = JSON.stringify(
            newUser
        );

        console.log(raw);

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw
        };

        fetch(url, requestOptions)
            .then(response => {
                if (response.status == 200) {
                    alert("SUCCESS!");
                    navigate("/Login"); // moved outside the then callback
                } else {
                    alert("FAILURE!");
                }
                return response.text() // added return statement
            })
            .catch(error => { console.log('error', error) });
    }




    return (

        <div className='Custom-center-form-container'>
            <div class="alert alert-danger" role="alert">
            </div>
            <div className='Custom-center-form'>
                <p><b><h4> Please Register Here...</h4></b></p>
                <form>

                    <div className="form-group">
                        <select className="form-control mt-1" name="role" id="role">
                            <option value="Seller">Seller</option>
                            <option value="Buyer">Buyer</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="username">Username:</label>
                        <input type="text" className="form-control mt-1" id="username" placeholder="Enter username" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="Email">Email:</label>
                        <input type="text" className="form-control mt-1" id="Email" placeholder="Enter Email" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password:</label>
                        <input type="password" className="form-control mt-1" id="password" placeholder="Enter password" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Confirm Password:</label>
                        <input type="password" className="form-control mt-1" id="password" placeholder="Confirm password" /><br />
                    </div>
                    <button type="submit" className="btn btn-primary form-control">Submit</button>
                </form>
            </div>
        </div>
    );
}



export default Register;



