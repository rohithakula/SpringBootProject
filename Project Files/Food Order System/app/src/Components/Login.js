import "../Components/Login.css";
import logo from '../Images/logo.jpg';
import { Link } from "react-router-dom";
import { useState } from "react";
import axios from "axios";
import { LoginCheck } from "../Services/userService";
import { useNavigate } from "react-router-dom";

 const Login = (props) => {

    const navigate = useNavigate();
    const submit = (event) =>{

      console.log(data);
      LoginCheck(data).then((resp)=>{
        // console.log(resp);
        // console.log("success");
        // navigate('/ClientOrder')
        if(resp.message=="Login Success"){

          console.log("success");
          props.fun(resp.id);
          navigate('/ClientOrder');
        }
        else{
          alert(resp.message);
          props.fun(resp.id);
        }
      //   alert("Details Added Successfully");
      //   document.getElementById("username").value='';
      // document.getElementById("email").value='';
      // document.getElementById("phone").value='';
      // document.getElementById("address").value='';
      // document.getElementById("password").value='';
      // document.getElementById("cpassword").value='';
      })
      .catch((error)=>{
        console.log(error);
        console.log("Error");
        
      })
    }
    const [data,setData] = useState({
      mail:'',
      password:''
    });

    const [error,setError] = useState({
      errors:'',
      isError:false
    });

    const changeValue1 = (event,property) => {
      setData({...data,[property]:event.target.value});
    };
    return (
        <div className="lmain">
        <div className="lform_container">
          <img src={logo}/>
          <h1>Food Ordering System</h1>
          <form>
            <input type="text" name="mail" id="mail" placeholder="Mail " required onChange={(e)=>changeValue1(e,"mail")}></input>
            <input type="password" name="password" id="password" placeholder="Password " required onChange={(e)=>changeValue1(e,"password")}></input>
            <input type="button" value="Login" onClick={submit}></input>
          </form>
          <p>Don't have an Account? <Link to="/SignUp">Sign Up</Link></p>
        </div>
      </div>
    );
  };

  export default Login;