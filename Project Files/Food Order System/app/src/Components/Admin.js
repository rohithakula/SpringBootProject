import "../Components/Admin.css";
import AdminHeader from "./AdminHeader";
import logo from "../Images/logo.jpg";
import { useEffect ,useState} from "react";
import { GetAll } from "../Services/foodService";
import { Delete } from "../Services/foodService";

const Admin = () =>{

    const [data,setData] = useState([]);
    useEffect(()=>{
    GetAll()
    .then((res)=>setData(res))
    .catch((error)=>{
        console.log(error);
        console.log("Error");
    });
},data);

    const deleteFood = (id) =>{
        Delete(id)
        .then((res)=>{
        console.log("Deleted");
        alert("Deleted Successfully");
        })
        .catch((error)=>{
            console.log(error);
            console.log("Error");
        });
    }
    return (
        <div className="amain">
            <AdminHeader/>
            <h2>Food Details</h2>
            <form className="search">
                <input type="text" placeholder="Search" required />
                <input type="submit" value="&#xf002;" class="fa"/>
                <input type="button" value="Add" />
            </form>
            <table>
            <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Hotel</th>
            <th>Actions</th>
        </tr>
        {
            data.map((food)=>(
                <tr>
            <td>{food.name}</td>
            <td>&#8377; {food.price}</td>
            <td>{food.hotel}</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash" onClick={deleteFood(food.id)}></i></td>
        </tr>
            ))
        }
        {/* <tr>
            <td>Biriyani</td>
            <td>&#8377; 120</td>
            <td>Rajadhani</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>Chicken Fry</td>
            <td>&#8377; 120</td>
            <td>Rajadhani</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>Fried Rice</td>
            <td>&#8377; 50</td>
            <td>Rajadhani</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>Fried Rice</td>
            <td>&#8377; 50</td>
            <td>Rajadhani</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>Fried Rice</td>
            <td>&#8377; 50</td>
            <td>Rajadhani</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>Fried Rice</td>
            <td>&#8377; 50</td>
            <td>Rajadhani</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr> */}
            </table>
        </div>
    )
}

export default Admin;