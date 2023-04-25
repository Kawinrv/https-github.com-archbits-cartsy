import React, { Component } from 'react';


class Login extends React.Component {

    constructor(props) {
        super(props);
    }



    render() {
        return (
            <div className='Custom-center-form-container'>
                <div className='Custom-center-form'>
                    <div className='h2'><p>Welcome, please signin...</p></div>

                    <div className='form-group'>
                        <input type="text" className='form-control mt-1' placeholder="username"></input>
                        <input type="password" className='form-control mt-1' placeholder="password"></input>
                    </div>
                    <br />
                    <button className='btn btn-primary form-control'>Signin</button>
                </div>
            </div>

        );

    }


}

export default Login;