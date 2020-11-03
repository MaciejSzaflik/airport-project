import React from "react";
import { DataGrid } from '@material-ui/data-grid';

class ArrivalsGrid extends React.Component {
  
  constructor(props) {
    super(props);
    let columns = [
      { field: 'time', headerName: 'TIME', width: 70 },
      { field: 'direction', headerName: 'DIRECTION', width: 130 },
      { field: 'flightNumber', headerName: 'FLIGHT NUMBER', width: 130 },
      { field: 'airline', headerName: 'AIRLINE', width: 130 },
      { field: 'status', headerName: 'STATUS', width: 130 },
    ]
    this.state = {
      data: props.data,
      columnsInfo: columns
    };
  }

  render() {
    return (
      <div style={{ height: 400, width: '100%' }}>
        <DataGrid rows={this.state.data} columns={this.state.columnsInfo} pageSize={5} checkboxSelection />
      </div>
    );
  }
}

export default ArrivalsGrid; 