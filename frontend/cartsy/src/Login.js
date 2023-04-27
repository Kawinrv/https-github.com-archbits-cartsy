import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.min.css';


class Login extends React.Component {

    constructor(props) {
        super(props);
    }



    render() {
        return (
            <div className='custom-Login-form-container'>
              <div className='custom-Login-form'>
              <p><b><h4> Please Sign in to continue...</h4></b></p>
                <form>
                  <div className="form-group">
                    <label htmlFor="username">Username:</label>
                    <input type="text" className="form-control mt-1" id="username" placeholder="Enter username" />
                  </div>
                  <div className="form-group">
                    <label htmlFor="password">Password:</label>
                    <input type="password" className="form-control mt-1" id="password" placeholder="Enter password" /><br/>
                  </div>
                  <button type="submit" className="btn btn-primary form-control">Submit</button>
                </form>
              </div>
            </div>
          );
        }
      }

export default Login;