import { Link } from "react-router-dom";
import "../Components/AdminHeader.css";
import logo from "../Images/logo.jpg";

const AdminHeader = () => {
    return(
        <div className="aheader">
                <div className="ahlogo">
                    <img src={logo} />
                    <h1>Food Ordering System</h1>
                </div>
                <div className="abuttons">
                    <Link to="/Admin"><a title="Food Deatails"><i class='fas fa-hamburger'></i></a></Link>
                    <Link to="/AdminAccounts"><a title="Account Deatils"><i class='fas fa-clipboard'></i></a></Link>
                    <Link to="/"><a title="Sign Out"><i class='fas fa-sign-out-alt'></i></a></Link>
                </div>
            </div>
    )
}

export default AdminHeader;