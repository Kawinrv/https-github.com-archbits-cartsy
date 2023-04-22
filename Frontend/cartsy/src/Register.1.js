import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.min.css';



class Register1 extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className='custom-Login-form-container'>
        <div className='custom-Login-form'>
        <p><b><h4> Please Register Here...</h4></b></p>
          <form>
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
              <input type="password" className="form-control mt-1" id="password" placeholder="Confirm password" /><br/>
            </div>
            <button type="submit" className="btn btn-primary form-control">Submit</button>
          </form>
        </div>
      </div>
    );
  }
}

export default Register1;




