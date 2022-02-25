import "./App.css";
import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";

class Students extends Component {
  constructor() {
    super();
    this.state = {
      students: [],
      userName: "",
      birthday: "",
      class: "",
      division: "",
      gender: "",
      nameError: "",
      formError: "",
    };
    this.handleChange = this.handleChange.bind(this);
    this.submit = this.submit.bind(this);
  }
  componentDidMount() {
    axios.get("http://localhost:8080/students").then((res) => {
      this.setState({
        students: res.data,
        id: 0,
        userName: "",
        birthday: "",
        class: "",
        division: "",
        gender: "",
        nameError: "",
        formError: "",
      });
    });
  }
  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }
  submit(
    event //fuction for handling submit
  ) {
    
    if (
      this.state.userName === "" ||
      this.state.birthday === "" ||
      this.state.class === "" ||
      this.state.division === "" ||
      this.state.gender === ""
    ) {
      this.setState({
        formError: "enter all fields in the form",
      });
    } else {
      this.setState({
        formError: "",
      });
      const regex = /^[A-Za-z ]*$/;
      let isValid = this.state.userName.match(regex); 
      if (isValid) {
        this.setState({
          nameError: "",
        });
        axios
          .post("http://localhost:8080/send", {
            
            userName: this.state.userName,
            standard: this.state.class,
            division: this.state.division,
            gender: this.state.gender,
            dob: this.state.birthday,
          })
          .then((res) => {
            
            this.componentDidMount();
          });
      } else {
        console.log("else part");
        this.setState({
          nameError: "enter name with letters and space only.",
        });
      }
    }
  }
  render() {
    return (
      <div className="students">
        <div className="container">
          <div className="row">
            <div className="login col-12 col-sm-12 col-md-5 col-lg-5">
              {" "}
              <div className="details">
                <h1 className="login-title text-center">Student Details</h1>
                <br></br>
                <form>
                  <input
                    type="text"
                    placeholder="Name"
                    className=" form-control name-field w-75 mx-auto "
                    name="userName"
                    value={this.state.userName}
                    onChange={this.handleChange}
                    pattern="^[A-Za-z ]+$"
                    required
                  />
                  <pre className="error  text-center">
                    {this.state.nameError}
                  </pre>{" "}
                  {/* for showing studentname error*/}
                  <br></br>
                  <div className="dob  text-center">
                    <label htmlFor="dob" className=" mx-auto text-center">
                      Date of Birth
                    </label>
                    <input
                      type="date"
                      id="birthday"
                      className="form-control form-control-sm w-75 mx-auto"
                      value={this.state.birthday}
                      onChange={this.handleChange}
                      name="birthday"
                    />
                  </div>
                  <br />
                  <div className="standard text-center">
                    <label htmlFor="class">Class details</label>
                    <select
                      value={this.state.class}
                      name="class"
                      className="form-control form-control-sm w-75 mx-auto"
                      onChange={this.handleChange}
                    >
                      <option value="">Select Class</option>
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="5">5</option>
                    </select>
                    <br />
                    <select
                      value={this.state.division}
                      name="division"
                      className="form-control form-control-sm w-75 mx-auto"
                      onChange={this.handleChange}
                    >
                      <option value="">Select Division</option>
                      <option value="A">A</option>
                      <option value="B">B</option>
                      <option value="C">C</option>
                      <option value="C">D</option>
                    </select>
                    <br />
                  </div>
                  <div className="gender text-center">
                    <label htmlFor="gender">Gender: </label>
                    <label>
                      <input
                        type="radio"
                        name="gender"
                        value="male"
                        checked={this.state.gender === "male"}
                        onChange={this.handleChange}
                      />{" "}
                      Male
                    </label>

                    <label>
                      <input
                        type="radio"
                        name="gender"
                        value="female"
                        checked={this.state.gender === "female"}
                        onChange={this.handleChange}
                      />{" "}
                      Female
                    </label>
                  </div>
                  <br />
                  <pre className="error  text-center">
                    {this.state.formError}
                  </pre>{" "}
                  {/* for showing input fields error*/}
                  <div className="text-center">
                    <button
                      type="button"
                      className="btn btn-outline-danger"
                      onClick={this.submit}
                    >
                      SUBMIT
                    </button>
                  </div>
                </form>
                <br />
              </div>
            </div>
            <div className="student-details col-12 col-sm-12 col-md-7 col-lg-7">
              {" "}
              <h1 className="login-title text-center">Students Information</h1>
              <table className="table table-dark">
                <thead className="thead-dark">
                  <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Class</th>
                    <th scope="col">Division</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Date of Birth</th>
                  </tr>
                </thead>
                <tbody>
                  {this.state.students.map(
                    (
                      student 
                    ) => (
                      <tr scope="row" key={student.rollNumber}>
                        <td>{student.userName}</td>
                        <td>{student.standard}</td>
                        <td>{student.division}</td>
                        <td>{student.gender}</td>
                        <td>{student.dob}</td>
                      </tr>
                    )
                  )}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Students);
