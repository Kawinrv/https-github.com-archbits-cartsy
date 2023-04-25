import React from 'react';
import { useNavigate } from "react-router";

const Home = () => {

    return (<div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container-fluid">
                <a className="navbar-brand" href="#">Cartsy</a>

                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">

                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <a className="nav-link" href="#">Deals</a>
                        </li>

                        <li className="nav-item">
                            <a className="nav-link" href="#" tabindex="-1">Bestsellers</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#" tabindex="-1">Latest</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#" tabindex="-1">Popular</a>
                        </li>
                    </ul>
                    < div className="container">
                        <form className="d-flex justify-content-center">
                            <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                            <button className="btn btn-outline-success" type="submit">Search</button>

                        </form>
                    </div>
                    <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Sign-in
                                </a>
                                <ul class="dropdown-menu dropdown-menu-dark dropdown-menu-end" aria-labelledby="navbarDarkDropdownMenuLink">
                                    <li><a class="dropdown-item" href="/login">Sign-in</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>





                </div>
            </div>
        </nav>
    </div>);
}

export default Home;