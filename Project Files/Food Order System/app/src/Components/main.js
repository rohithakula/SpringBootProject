import { Link } from "react-router-dom";
import "../Components/Main.css";
import logo from '../Images/logo.jpg';

const Main = () =>{
    return(
        <div className="main">
            <div className="mheader">
                <img src={logo} />
                <h1>Food Ordering System</h1>
            </div>
            <div className="mfirst">
                <div className="mlogo">
                    <img src={logo}/>
                    <h2>"Order with ease, savor with delight."</h2>
                </div>
                <div className="mbuttons">
                    <Link to={"/Login"}><button >Login as Customer</button></Link>
                    <Link to={"/Admin"}><button>Login as Admin</button></Link>
                    {/* <Link to={"/Login"}><button>Login as Restaurant</button></Link> */}
                </div>
            </div>
            <div className="maboutus">
                <div className="mcontent">
                <h1>About Us</h1>
                <p>Welcome to Food Ordering System! We are your ultimate destination for convenient and delicious online food ordering. At Food Ordering System, we strive to connect food lovers with their favorite restaurants, bringing the joy of dining right to your doorstep.</p>
                <p>Our platform was created with the vision of revolutionizing the way people order food. With just a few clicks, you can explore a vast array of culinary options and effortlessly place your order from the comfort of your own home or office. Whether you're craving a comforting bowl of pasta, a sizzling burger, or exotic cuisines from around the world, we have you covered.</p>
                <p>Customer satisfaction is our top priority, and we strive to exceed your expectations every time you use our platform. Our dedicated customer support team is available to assist you with any queries or concerns you may have, ensuring a seamless and enjoyable experience from start to finish.</p>
                <p>Join us on this culinary journey and discover the convenience, variety, and quality that Food Ordering System has to offer. Embrace the ease of online food ordering and indulge in the flavors you love, delivered right to your doorstep. Bon appétit!</p>
                </div>
            </div>
            <div className="mcontact">
                <h1>Contact Us : </h1>
                <p>Email : foodorder@gmail.com</p>
                <p>Phone : +91 xxxxxxxxxx</p>
                <div className="micons">
                    <a href=""><i class="fa fa-facebook"></i></a>
                    <a href=""><i class="fa fa-instagram"></i></a>
                    <a href=""><i class="fa fa-youtube"></i></a>
                </div>
            </div>
        </div>
    );
};

export default Main;