import logo from "../src/Images/logo.jpg";
import './App.css';
import Login from './Components/Login';
import SignUp from "./Components/SignUp";
import Main from "./Components/main";
import ClientOrder from "./Components/ClientOrder";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Personal from "./Components/Personal";
import Admin from "./Components/Admin";
import AdminAccounts from "./Components/AdminAccounts";
import { useState } from "react";


function App() {

  const [id,setId] = useState();
  const changeId = (data) => {
    setId(data);
  }
  const [total,setTotal] = useState(0);
  const changeTotal = (data) => {
    setTotal(total+data);
  }
  return (
    <div className="App">
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Main/>}/>
      <Route path="/Login" element={<Login fun={changeId}/>}/>
      <Route path="/SignUp" element={<SignUp/>}/>
      <Route path="/ClientOrder" element={<ClientOrder func={changeTotal} total={total}/>}/> 
      <Route path="/PersonalDetails" element={<Personal id={id}/>}  total={total}/>
      <Route path="/Admin" element={<Admin/>}/>
      <Route path="/AdminAccounts" element={<AdminAccounts/>}/>
    </Routes>
  </BrowserRouter>
  </div>
  );
}

export default App;
