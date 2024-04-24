import React, { Component } from 'react'
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useStripe, useElements, CardElement } from '@stripe/react-stripe-js';
import { Elements } from '@stripe/react-stripe-js';
import { loadStripe } from '@stripe/stripe-js';
import 'animate.css'
import FlightService from '../Service/FlightService';
import { BiCheckCircle } from 'react-icons/bi'
import CheckoutForm from './CheckoutForm';

const stripePromise = loadStripe('pk_test_51P6a3w07b4pLNc6mR07eBua2uFTTGduFoBFqSAAA7PgckcSmKh4Rty2ro0dQZAwbjGSatyD4dXK2fteem28xO0pj00DcWoRZiY');

class Passenger_Payment extends Component {
    constructor(props) {
        super(props);
        this.state = {
            flight_No: this.props.location.state.flight_No,
            total_Amount: this.props.location.state.cost,
            class_Type: this.props.location.state.class_Type,
            name: '',
            gender: '',
            dob: '',
            passport_No: '',
            type_Of_Payment: '',
            card_No: '',
            exp_Date: '',
            cvv: '',
            name_On_Card: ''
        }

        this.changeFullName = this.changeFullName.bind(this);
        this.changeGender = this.changeGender.bind(this);
        this.changeDOB = this.changeDOB.bind(this);
        this.changePassport_No = this.changePassport_No.bind(this);
        this.changePaymentType = this.changePaymentType.bind(this);
        this.changeCard_No = this.changeCard_No.bind(this);
        this.changeExp_Date = this.changeExp_Date.bind(this);      //not in db
        this.changeCVV = this.changeCVV.bind(this);                //not in db
        this.changeName_On_Card = this.changeName_On_Card.bind(this);


        this.submitData = this.submitData.bind(this);
    }

    componentDidMount() {

    }

    async submitData(event) {

        let userData = {
            flight_No: this.state.flight_No, name: this.state.name, gender: this.state.gender, dob: this.state.dob, passport_No: this.state.passport_No,
            type_Of_Payment: this.state.type_Of_Payment, card_No: this.state.card_No, name_On_Card: this.state.name_On_Card,
            class_Type: this.state.class_Type, total_Amount: this.state.total_Amount, id: sessionStorage.getItem('Id')
        }
        console.log('userData =>' + JSON.stringify(userData));

        FlightService.booking(userData).then(res => {
            console.log("After submitting, data returned is: " + res.data);
            toast.success(<div>&nbsp;<BiCheckCircle />&nbsp;{"Your ticket has been successfully booked."}</div>, {
                position: "top-center",
                hideProgressBar: true,
                autoClose: 3000,
                pauseOnHover: false,
            });
            setTimeout(function () {
                window.location.replace('/bookings');
            }, 3000);
        });

        const stripe = useStripe();
        const elements = useElements();

        const { error, paymentMethod } = await stripe.createPaymentMethod({
            type: 'card',
            card: elements.getElement(CardElement),
            billing_details: {
                name: '',
                phone: '',
                email: '',
                address: {
                    city: '',
                    state: '',
                    postal_code: '',
                    line1: '',
                    line2: '',
                }
            },
        });


        event.preventDefault();
    }


    changeFullName(event) {
        this.setState({ name: event.target.value });
    }

    changeGender(event) {
        this.setState({ gender: event.target.value });
    }

    changeDOB(event) {
        this.setState({ dob: event.target.value });
    }

    changePassport_No(event) {
        this.setState({ passport_No: event.target.value });
    }

    changePaymentType(event) {
        this.setState({ type_Of_Payment: event.target.value });
    }

    changeCard_No(event) {
        this.setState({ card_No: event.target.value });
    }

    changeExp_Date(event) {
        this.setState({ exp_Date: event.target.value });
    }

    changeCVV(event) {
        this.setState({ cvv: event.target.value });
    }

    changeName_On_Card(event) {
        this.setState({ name_On_Card: event.target.value });
    }



    render() {
        const rounded = {
            borderRadius: "20px",
            boxShadow: "1px 1px 10px 5px #778899"
        }

        const style1 = {
            backgroundColor: "rgba(230, 230, 230, 0.6000)",
        };

        const product = {
            price: this.state.total_Amount,
            name: this.state.name_On_Card,
            description: this.state.flight_No,
            image: '',
          };

          let userData = {
            flight_No: this.state.flight_No, name: this.state.name, gender: this.state.gender, dob: this.state.dob, passport_No: this.state.passport_No,
            type_Of_Payment: this.state.type_Of_Payment, card_No: this.state.card_No, name_On_Card: this.state.name_On_Card,
            class_Type: this.state.class_Type, total_Amount: this.state.total_Amount, id: sessionStorage.getItem('Id')
        }

        return (
                <div className=" paymentBgImg overflow" >
                    <div className="container">
                        <CheckoutForm product={product} userData={userData}/>
                    </div>
                    <br></br>
                </div>
        )
    }
}
export default Passenger_Payment