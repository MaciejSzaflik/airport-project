import React from "react";
import Typography from '@material-ui/core/Typography';
import ArrivalsGrid from './arrivalsGrid';
import DepartureGrid from './departureGrid';

class GridCreator extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      items: null,
      infoType: "none"
    };
    props.emitter.on('flightsDataRecived', (data)=> this.createGrid(data));
    this.arrivalGridRef = React.createRef();
    this.departureGridRef = React.createRef();
  }

  createGrid(eventData)
  {
    this.setState((state, props) => ({
      items: eventData.data,
      infoType: eventData.infoType
    }));

    if(this.arrivalGridRef!=null && eventData.infoType == "arrivals")
      this.arrivalGridRef.current.changeData(eventData.data);
    if(this.departureGridRef!=null && eventData.infoType == "departures")
      this.departureGridRef.current.changeData(eventData.data);
  }

  render() {
    const { items, infoType } = this.state;

    if(infoType == "arrivals" && items!=null)
    { 
      return (
        <div>
          <ArrivalsGrid ref={this.arrivalGridRef} data={items}></ArrivalsGrid>
        </div>
      )
    }
    else if(infoType == "departures" && items!=null)
    {
      return (
        <div>
          <DepartureGrid ref={this.departureGridRef} data={items}></DepartureGrid>
        </div>
      )
    }

    return (
      <Typography paragraph>
      Please select airport from list on the left
      </Typography>
    );
  }
}

export default GridCreator; 