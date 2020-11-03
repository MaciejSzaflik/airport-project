import React from "react";
import ReactDOM from "react-dom";
import AirportList from './components/airportList';

import './index.css';

const App = () => {
  return (
    <div>
        <div>Airport List</div>
        <AirportList />
    </div>

  );
};

ReactDOM.render(
  <App />, 
  document.querySelector('#react')
);