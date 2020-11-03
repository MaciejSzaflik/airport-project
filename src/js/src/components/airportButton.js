import React from "react";
import { Button } from '@material-ui/core';
import ArrivalsGrid from "./arrivalsGrid";

class AirportButton extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      error: null,
      airport: props.airport,
      hasResponse: false,
      arrivalData: null,
      departureData: null,
    };
  }

  onBtnClick(type) {
    let mainUrl = "https://infinite-brook-01188.herokuapp.com/airports/";
    let urlToFetch = `${mainUrl}/${type}/${this.state.airport.id}`;
    
    fetch(urlToFetch)
      .then(res => res.json())
      .then(
        (result) => {
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
        <Button color="primary" onClick={() =>this.onBtnClick("depatures")}>  Departure</Button>
      </div>
    )
    let table = null;
    console.log(infoType);
    console.log(hasResponse);
    if(infoType == "arrivals" && hasResponse)
    { 
      return (
        <div>
          {buttons}
          <ArrivalsGrid data={items}></ArrivalsGrid>
        </div>
      )
    }
    else (infoType == "depatures" && hasResponse)
    {
      table = null;
    }

    return (
      <div>
        {buttons}
      </div>
    )
    
  }
}

export default AirportButton; 