import React from "react";
import AirportButton from "./airportButton";

class AirportList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    };
  }

  componentDidMount() {
    fetch("https://infinite-brook-01188.herokuapp.com/airports")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            items: result
          });
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      )
  }

  render() {
    const { error, isLoaded, items } = this.state;
    if (error) {
      return <div>Error: {error.message}</div>
    } else if (!isLoaded) {
      return <div>Loading...</div>
    } else {
      this.airportList = items._embedded.airportList;
      return (
        <ul>
        {this.airportList.map(item => (
          <li key={item.name}>
            <div>{item.name}</div>
            <AirportButton airport={item}/>
          </li>
        ))}
        </ul>
      )
    }
  }
}

export default AirportList; 