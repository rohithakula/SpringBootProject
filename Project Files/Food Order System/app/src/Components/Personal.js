import Header from "./Header";
import "../Components/Personal.css";
import { useState ,useEffect} from "react";
import { Link } from "react-router-dom";
import { GetUser } from "../Services/userService";

const Personal = (props) => {

    const [style,setStyle] = useState("pmain");
    const [data,setData] = useState({
        name:'',
        mail:'',
        number:'',
        address:''
    })
    // useEffect(() => {

        GetUser(props.id)
        .then((res)=>{
            setData({
                name:res.name,
                mail:res.mail,
                number:res.number,
                address:res.address
            })  
        }
        ).catch((error)=>{
            console.log(error);
            console.log("Error");
        })
    // });

    

    const styleCahnge = (data) => {
        setStyle(data);
    }

    return(
        <div className={style}>
            <Header func1={styleCahnge} name="pmain" total={0}/>
            <div className="details">
                <div className="info"><h2 className="head">Name : </h2><h2>{data.name}</h2></div>
                <div className="info"><h2 className="head">Email : </h2><h2>{data.mail}</h2></div>
                <div className="info"><h2 className="head">Phone Number : </h2><h2>+91 {data.number}</h2></div>
                <div className="info"><h2 className="head">Address : </h2><h2>{data.address}</h2></div>
                <Link to="/"><button>Log Out</button></Link>
            </div>
            <div className="ccontact">
                <h1>Contact Us : </h1>
                <p>Email : foodorder@gmail.com</p>
                <p>Phone : +91 xxxxxxxxxx</p>
                <div className="cicons">
                    <a href=""><i class="fa fa-facebook"></i></a>
                    <a href=""><i class="fa fa-instagram"></i></a>
                    <a href=""><i class="fa fa-youtube"></i></a>
                </div>
            </div>
        </div>
    )

}

export default Personal;