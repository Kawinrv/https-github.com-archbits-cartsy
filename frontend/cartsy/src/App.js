import React, {Component} from 'react';
import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Login from './Login'
import Register from './Register'
import Navbar from './Navbar';
import Home from './Home'
import MyShop from './MyShop';
import SellerProduct from './SellerProduct';
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"



function App() {
  
  return (
    <div>
      <React.StrictMode>
    <Navbar/>
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" element={<Register/>}/>
        <Route path="/home" element={<Home/>}/>
        <Route path="/myshop" element={<MyShop/>}/>
        <Route path="/sproduct" element={<SellerProduct/>}/>
      </Routes>
    </BrowserRouter>
    </React.StrictMode>
    </div>
  );
  
}

export default App;
