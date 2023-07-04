import { useState } from "react";
import "../Components/Card.css";
import Ramen from "../Images/ramen.jpg";
import Soup from "../Images/soup.jpg";
import Meals from "../Images/meals.jpg";
import ChickenFry from "../Images/chickenfry.jpg";
import Pasta from "../Images/pasta.jpg";

const Card = (props) => {
    const [quantity,setQuantity] = useState(1);
    const incriment = () =>{
        setQuantity(quantity+1);
    }
    const decriment = () =>{
        if(quantity>1){
            setQuantity(quantity-1);
        }
        else{
            setQuantity(1);
        }
    }
    const addToCart = () => {
        // setCartItem({
        //     name:props.name,
        //     price:props.price,
        //     quan:quantity
        // })
        props.func(quantity);
    }
    // const [cartItem,setCartItem] =useState({
    //     name:"",
    //     price:0,
    //     quantity:0
    // })
    
    return (
        <div className="card">
            {/* <img src="../Components/biriyani.png"/> */}
            <p>{props.name}</p>
            <p>{props.hotel} Hotel</p>
            <p>&#8377; {props.price}</p>
            <p><i class="fa fa-minus-square" onClick={decriment}></i>{quantity}<i class="fa fa-plus-square" onClick={incriment}></i></p>
            <button onClick={addToCart}>Add to Cart</button>
        </div>
    );
};

export default Card;