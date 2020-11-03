import React from "react";
import { DataGrid } from '@material-ui/data-grid';

class DepartureGrid extends React.Component {
  
  constructor(props) {
    super(props);
    let columns = [
      { field: 'time', headerName: 'TIME', width: 70 },
      { field: 'direction', headerName: 'DIRECTION', width: 200 },
      { field: 'flightNumber', headerName: 'FLIGHT NUMBER', width: 200 },
      { field: 'airline', headerName: 'AIRLINE', width: 200 },
      { field: 'status', headerName: 'STATUS', width: 200 },
      { field: 'checkIn', headerName: 'CHECK-IN', width: 200 },
      { field: 'gate', headerName: 'GATE', width: 200 },
    ]
    this.state = {
      data: props.data,
      columnsInfo: columns
    };
  }

  render() {
    return (
      <div style={{ height: 400, width: '100%' }}>
        <DataGrid rows={this.state.data} columns={this.state.columnsInfo} pageSize={30} />
      </div>
    );
  }
}

export default DepartureGrid; 