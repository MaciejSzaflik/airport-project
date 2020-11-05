import React from "react";
import Typography from '@material-ui/core/Typography';
import ArrivalsGrid from './arrivalsGrid';
import DepartureGrid from './departureGrid';
import LinearProgress from '@material-ui/core/LinearProgress';

class GridCreator extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      items: null,
      infoType: "none",
      isLoading: false,
    };
    props.emitter.on('flightsDataRecived', (data)=> this.createGrid(data));
    props.emitter.on('loadingStarted', ()=> this.loadingStarted());
    this.arrivalGridRef = React.createRef();
    this.departureGridRef = React.createRef();
  }

  loadingStarted()
  {
    this.setState((state, props) => ({
      infoType: "loading",
      isLoading: true
    }));
  }

  createGrid(eventData)
  {
    this.setState((state, props) => ({
      items: eventData.data,
      infoType: eventData.infoType,
      isLoading: false
    }));

    if(this.arrivalGridRef!=null && eventData.infoType == "arrivals")
      this.arrivalGridRef.current.changeData(eventData.data);
    if(this.departureGridRef!=null && eventData.infoType == "departures")
      this.departureGridRef.current.changeData(eventData.data);
  }

  render() {
    const { items, infoType, isLoading } = this.state;

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
    else if(isLoading)
    {
      return (
        <LinearProgress />
      );
    }
    else
    {
      return (
        <Typography paragraph>
        Please select airport from list on the left
        </Typography>
      );
    }
  }
}

export default GridCreator; 