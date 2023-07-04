import { Link } from "react-router-dom";
import "../Components/Header.css";
import logo from '../Images/logo.jpg';
import React, { useState } from "react";
import Modal from "react-overlays/Modal";
import Cart from "./Cart";

const Header = (props) =>{
    const [showModal, setShowModal] = useState(false)

    const renderBackdrop = (props) => <div className="backdrop" {...props} />;

    const handleClose = () => {
        setShowModal(false);
        props.func1(props.name);
    }

    const cartClick = () =>{
        setShowModal(true);
        props.func1(props.name+" background");
    }

    return(
        <div className="hheader">
            <div className="hlogo">
                <img src={logo} />
                <h1>Food Ordering System</h1>
            </div>
            <div className="hbuttons">
                <Link to="/ClientOrder"><a className="home" title="Home Page"><i class="fa fa-home"></i></a></Link>
                <a onClick={cartClick}><i class="fa fa-shopping-cart" title="Cart"></i><span>{props.total}</span></a>
                <Link to="/PersonalDetails"><a><i class="fa fa-user-circle" title="Personal Details"></i></a></Link>
                <Link to="/"><a title="Sign Out" className="signout"><i class='fas fa-sign-out-alt'></i></a></Link>
            </div>
            <Modal
                className="modal"
                show={showModal}
                onHide={handleClose}
                renderBackdrop={renderBackdrop} >
                <Cart func={handleClose} />
            </Modal>
        </div>
        
    )
}

export default Header;