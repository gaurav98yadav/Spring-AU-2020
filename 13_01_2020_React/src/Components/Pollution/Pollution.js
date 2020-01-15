import React, { Component } from 'react';
import './Pollution.css';
import { connect } from 'react-redux';
export const FETCH_POLLUTION_SUCCESS = 'FETCH_POLLUTION_SUCCESS';
export const FETCH_POLLUTION_FAILURE = 'FETCH_POLLUTION_FAILURE';
export const SET_DATA = 'SET_DATA';

export function fetchPollution() {
    return dispatch => {
        return fetch("data.json")
        .then(res => res.json())
        .then(data => {
            dispatch(fetchPollutionSuccess(data));
            return data.pollution
        })
        .catch(error => dispatch(fetchPollutionFailure(error)));
    };
}

const fetchPollutionSuccess = pollution => ({
    type: FETCH_POLLUTION_SUCCESS,
    payload: { pollution }
});

const fetchPollutionFailure = error => ({
    type: FETCH_POLLUTION_FAILURE,
    payload: { error }
});

export const setData = filter => ({
    type: SET_DATA,
    payload: { filter }
});

class Pollution extends Component {

  componentDidMount(){
    this.props.dispatch(fetchPollution());
  }

  search = (e) => {
    var searchValue = e.target.value;
    var reg = new RegExp(searchValue);
    this.props.dispatch(setData(reg));
  }

  render() {

    const { error, pollution } = this.props;
    const filteredData = pollution.map((item) => (<li key={item.id}> {item.state}</li>)); 

    if (error) {
      return <div>Error! {error.message}</div>;
    }

    return (
      <div className="Pollution">
        <h1>List of States</h1>
        <input type="text" id ="search" placeholder="Search for the States" onKeyUp={this.search}></input>
        <div>
            <ul >
                {filteredData}
            </ul>      
        </div>
        <br />
        <br />
        

      </div>
    );
  }
}

function mapStateToProps(state) {
  return {
      pollution: state.pollution
  };
}

export default connect(mapStateToProps)(Pollution);