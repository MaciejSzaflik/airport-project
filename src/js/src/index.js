import React from "react";
import ReactDOM from "react-dom";
import MainParent from './components/mainParent';
import { makeStyles } from '@material-ui/core/styles';

import './index.css';

const drawerWidth = `20%`;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
  },
  appBar: {
    width: `calc(100% - ${drawerWidth})`,
    marginLeft: drawerWidth,
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
  },
  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.default,
    padding: theme.spacing(3),
  },
}));

const App = () => {
  return (
    <MainParent classesItem={useStyles()}/>
  );
};

ReactDOM.render(
  <App />, 
  document.querySelector('#react')
);