import React from 'react';

import Drawer from '@material-ui/core/Drawer';
import CssBaseline from '@material-ui/core/CssBaseline';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import AirportList from './airportList';
import GridCreator from './gridCreator';
import { EventEmitter } from 'events';

class MainParent extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        classes: props.classesItem,
        emitter: new EventEmitter ()
      };
    }

    render() {
      const { classes, emitter } = this.state;
      return (
      <div className={classes.root}>
        <CssBaseline />
        <AppBar position="fixed" className={classes.appBar}>
          <Toolbar>
            <Typography>Arrivals/Departures</Typography>
          </Toolbar>
        </AppBar> 
        <Drawer
          className={classes.drawer}
          variant="permanent"
          classes={{
            paper: classes.drawerPaper,
          }}
          anchor="left"
        >
          <div className={classes.toolbar} />
          <Divider />
          <AirportList emitter={emitter}/>
          <Divider />
        </Drawer>
        <main className={classes.content}>
          <div className={classes.toolbar} />

          <GridCreator emitter={emitter}/>          
        </main>
      </div>
    );
  }
}

export default MainParent; 
