import { Link } from "react-router-dom";
import "../Components/SignUp.css";
import logo from '../Images/logo.jpg';
import { SignUpAdd } from "../Services/userService";
import { useState } from "react";

 const SignUp = () => {

    const [data,setData] = useState({
      name:'',
      mail:'',
      number:'',
      address:'',
      password:''
    })

    const [error,setError] = useState({
      errors:'',
      isError:false
    });

    const changeValue = (event,property) => {
      setData({...data,[property]:event.target.value});
    }

    const submitForm = (event) =>{
      // event.preventDefault();
      console.log(data);
      SignUpAdd(data).then((resp)=>{
        console.log(resp);
        console.log("success");
        alert("Details Added Successfully");
        document.getElementById("username").value='';
      document.getElementById("email").value='';
      document.getElementById("phone").value='';
      document.getElementById("address").value='';
      document.getElementById("password").value='';
      document.getElementById("cpassword").value='';
      })
      .catch((error)=>{
        console.log(error);
        console.log("Error");
        
      })
    }

    return (
        <div className="smain">
        <div className="sform_container">
          <img src={logo}/>
          <h1>Food Ordering System</h1>
          <form>
            <input type="text" name="username" id="username" placeholder="Username " required onChange={(e)=>changeValue(e,"name")}></input>
            <input type="email" name="email" id="email" placeholder="Email " required onChange={(e)=>changeValue(e,"mail")}></input>
            <input type="tel" name="phone" id="phone" placeholder="Phone Number" required pattern="[0-9]{10}" onChange={(e)=>changeValue(e,"number")}></input>
            <input type="text" id="address" name="address" placeholder="Address" onChange={(e)=>changeValue(e,"address")}></input>
            <input type="password" name="password" id="password" placeholder="Password " required onChange={(e)=>changeValue(e,"password")}></input>
            <input type="password" name="cpassword" id="cpassword" placeholder="Comfirm Password " required></input>
            <input type="button" value="Sign Up" onClick={submitForm}></input>
          </form>
          <p>Already have an Account? <Link to="/Login" >Login</Link></p>
        </div>
      </div>
    );
  };

  export default SignUp;