import React from "react";
import AirportButton from "./airportButton";
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import CircularProgress from '@material-ui/core/CircularProgress';
import ListItemText from '@material-ui/core/ListItemText';


class AirportList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      emitter: props.emitter,
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
  
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      )
  }

  render() {
    const { error, isLoaded, items, emitter } = this.state;
    let listItems;
    if (error) {
      listItems = (
        <ListItem button key={"Error"}>
                <ListItemText primary={`Error: ${error.message}`} />
        </ListItem>
      )
    } else if (!isLoaded) {
      listItems = (
        <ListItem button key={"Loading"}>
              <CircularProgress />
        </ListItem>
      )
    } else {
      this.airportList = items._embedded.airportList;
      listItems = (
        this.airportList.map(item => (
          <ListItem key={item.name}>
            <ListItemText primary={item.name} />
            <AirportButton airport={item} emitter={emitter}/>
          </ListItem>
        ))
      )
    }

    return (
      <List>
        {listItems}
      </List>
    );

  }
}

export default AirportList; 