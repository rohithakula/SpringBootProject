import { Link } from "react-router-dom";
import "../Components/ClientOrder.css";
import Header from "./Header";
import Card from "./Card";
import { useEffect, useState } from "react";
import { GetAll } from "../Services/foodService";
import Ramen from "../Images/ramen.jpg";
import Soup from "../Images/soup.jpg";
import Meals from "../Images/meals.jpg";
import ChickenFry from "../Images/chickenfry.jpg";
import Pasta from "../Images/pasta.jpg";


const ClientOrder = (props) =>{

    const [style,setStyle] = useState("cmain");
    // const [total,setTotal] = useState(0);

    // const totalChange = (data) => {
    //     setTotal(total+data);
    //     // setCartData(...cartData,data);
    // }

    // const [cartData,setCartData] = useState([]);

    const styleCahnge = (data) => {
        setStyle(data);
    }
    const [data,setData] = useState([]);
    useEffect(()=>{
    GetAll()
    .then((res)=>setData(res))
    .catch((error)=>{
        console.log(error);
        console.log("Error");
    });
},data);



    return (
        <div className={style}>
            <Header func1={styleCahnge} name="cmain" total={props.total} />
            <form className="search">
                <input type="text" placeholder="Search" required/>
                <input type="submit" value="&#xf002;" class="fa"/>
            </form>
            <div className="ccards">
                {
                    data.map((food)=>(
                        
                        <Card image={food.name} name={food.name} hotel={food.hotel} price={food.price} key={food.id} func={props.func} />
                        
                    ))
                }
                {/* <Card image={Biriyani} name="Biriyani" hotel="Rajadhani" price="120" />
                <Card image={Biriyani} name="Biriyani" hotel="Rajadhani" price="120" />
                <Card image={Biriyani} name="Biriyani" hotel="Rajadhani" price="120" />
                <Card image={Biriyani} name="Biriyani" hotel="Rajadhani" price="120" />
                <Card image={Biriyani} name="Biriyani" hotel="Rajadhani" price="120" />
                <Card image={Biriyani} name="Biriyani" hotel="Rajadhani" price="120" />
                <Card image={Biriyani} name="Biriyani" hotel="Rajadhani" price="120" />
                <Card image={Biriyani} name="Biriyani" hotel="Rajadhani" price="120" /> */}
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

export default ClientOrder;