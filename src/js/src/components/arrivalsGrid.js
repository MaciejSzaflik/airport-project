import React from "react";
import { DataGrid } from '@material-ui/data-grid';

class ArrivalsGrid extends React.Component {
  
  constructor(props) {
    super(props);
    let columns = [
      { field: 'time', headerName: 'TIME', width: 70 },
      { field: 'direction', headerName: 'DIRECTION', width: 180 },
      { field: 'flightNumber', headerName: 'FLIGHT NUMBER', width: 180 },
      { field: 'airline', headerName: 'AIRLINE', width: 180 },
      { field: 'status', headerName: 'STATUS', width: 180 },
    ]
    this.state = {
      data: props.data,
      emitter: props.emitter,
      columnsInfo: columns,
    };
  }

  render() {
    return (
      <div style={{ height: 700, width: '100%' }}>
        <DataGrid rows={this.state.data} columns={this.state.columnsInfo} pageSize={30} />
      </div>
    );
  }
}

export default ArrivalsGrid; 