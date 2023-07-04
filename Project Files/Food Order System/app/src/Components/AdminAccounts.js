import "../Components/AdminAccounts.css";
import AdminHeader from "./AdminHeader";
import logo from "../Images/logo.jpg";
import { GetAllUsers ,DeleteUSer} from "../Services/userService";
import { useEffect ,useState} from "react";

const AdminAccounts = () => {

    const [data,setData] = useState([]);
    useEffect(()=>{
    GetAllUsers()
    .then((res)=>setData(res))
    .catch((error)=>{
        console.log(error);
        console.log("Error");
    });
},data);

const deleteUser = (id) =>{
    DeleteUSer(id)
    .then((res)=>{
    console.log("Deleted");
    alert("Deleted Successfully");
    })
    .catch((error)=>{
        console.log(error);
        console.log("Error");
    });
}
    return(
        <div className="adminaccounts">
            <AdminHeader/>
            <h2>Account Details</h2>
            <form className="search">
                <input type="text" placeholder="Search" required />
                <input type="submit" value="&#xf002;" class="fa"/>
                <input type="button" value="Add" />
            </form>
            <table>
            <tr>
            <th>Name</th>
            <th>Mail</th>
            <th>Phone</th>
            <th>Actions</th>
        </tr>
        {
            data.map(user=>(
                <tr>
            <td>{user.name}</td>
            <td>{user.mail}</td>
            <td>+91 {user.number}</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash" onClick={deleteUser(user.id)}></i></td>
        </tr>
            ))
        }
        {/* <tr>
            <td>User1</td>
            <td>user1@gmail.com</td>
            <td>+91 xxxxxxxxxx</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>User1user</td>
            <td>user1user@gmail.com</td>
            <td>+91 xxxxxxxxxx</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>User1</td>
            <td>user1@gmail.com</td>
            <td>+91 xxxxxxxxxx</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>User1</td>
            <td>user1@gmail.com</td>
            <td>+91 xxxxxxxxxx</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>User1</td>
            <td>user1@gmail.com</td>
            <td>+91 xxxxxxxxxx</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>User1</td>
            <td>user1@gmail.com</td>
            <td>+91 xxxxxxxxxx</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>User1</td>
            <td>user1@gmail.com</td>
            <td>+91 xxxxxxxxxx</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>User1user</td>
            <td>user1user@gmail.com</td>
            <td>+91 xxxxxxxxxx</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr>
        <tr>
            <td>User1</td>
            <td>user1@gmail.com</td>
            <td>+91 xxxxxxxxxx</td>
            <td><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td>
        </tr> */}
            </table>
        </div>
    )
}

export default AdminAccounts;