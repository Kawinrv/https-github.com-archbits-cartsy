import React, {Component} from 'react';
import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Login from './Login'
import Register from './Register'
import Home from './Home'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"



function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" element={<Register/>}/>
        <Route path="/home" element={<Home/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
