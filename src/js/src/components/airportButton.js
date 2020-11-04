import React from "react";
import {Button} from '@material-ui/core';

class AirportButton extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      error: null,
      emitter: props.emitter,
      airport: props.airport,
      hasResponse: false,
      infoType: "none",
      arrivalData: null,
      departureData: null,
    };
  }

  onBtnClick(type) {
    let mainUrl = "https://infinite-brook-01188.herokuapp.com/airports";
    let urlToFetch = `${mainUrl}/${type}/${this.state.airport.id}`;
    
    fetch(urlToFetch)
      .then(res => res.json())
      .then(
        (result) => {
          this.state.emitter.emit(
            "flightsDataRecived", {
            infoType: type,
            data:  result
          });

          this.setState({
            hasResponse: true,
            infoType: type,
            items: result
          });
        },
        (error) => {
          this.setState({
            hasResponse: true,
            error
          });
        }
      )
  }

  render() {
    const { error, hasResponse, items, infoType } = this.state;

    let buttons = (
      <div>
        <Button color="primary" onClick={() =>this.onBtnClick("arrivals")}>  Arrival </Button>
        <Button color="primary" onClick={() =>this.onBtnClick("departures")}>  Departure</Button>
      </div>
    )
    
    return (
      <div>
        {buttons}
      </div>
    )
  }
}

export default AirportButton; 