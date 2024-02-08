import './App.css';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Home from "./component/pages/Home";
import Login from "./component/pages/Login";
import React from "react";
import Register from "./component/pages/Register";

function App() {
  return (
    <div>
      <Router>
          <Switch>
              <Route path="/" exact component={Home}></Route>
              <Route path="/login" exact component={Login}></Route>
              <Route path="/register" exact component={Register}></Route>
              <Route path="/login" exact component={Login}></Route>
              <Route path="/login" exact component={Login}></Route>
          </Switch>
      </Router>
    </div>
  );
}

export default App;
