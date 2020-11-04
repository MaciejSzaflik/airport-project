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
  }

  createGrid(eventData)
  {
    this.setState({
      items: eventData.data,
      infoType: eventData.infoType
    });
  }

  render() {
    const { items, infoType } = this.state;

    if(infoType == "arrivals" && items!=null)
    { 
      return (
        <div>
          <ArrivalsGrid data={items}></ArrivalsGrid>
        </div>
      )
    }
    else if(infoType == "departures" && items!=null)
    {
      return (
        <div>
          <DepartureGrid data={items}></DepartureGrid>
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