import "../Components/Cart.css";

const Cart = (props) => {
    return(
        <div className="cart">
            <div className="citem">
                <div className="details">
                    <p>Biriyani</p>
                    <p className="price">&#8377; 190 <span className="quantity">x2</span></p>
                </div>
                <i class="fa fa-trash"></i>
            </div>
            <div className="citem">
                <div className="details">
                    <p>Chicken Fry</p>
                    <p className="price">&#8377; 150 <span className="quantity">x1</span></p>
                </div>
                <i class="fa fa-trash"></i>
            </div>
            <div className="total">
                <p>Total Amount</p>
                <p>&#8377; 530</p>
            </div>
            <div className="cart_buttons">
                <button onClick={props.func} className="close">Close</button>
                <button onClick={props.func} className="order">Order</button>
            </div>
        </div>
    )
}

export default Cart;