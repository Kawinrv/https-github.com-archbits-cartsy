import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './Login';
import Register1 from './Register.1';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/Login" element={<Login/>}/>
        <Route path="/Register1" element={<Register1/>}/>
      </Routes >
    </BrowserRouter>
  );
}

export default App;
