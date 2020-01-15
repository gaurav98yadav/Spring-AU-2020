const initialState = {
    pollution: [],
    filter: [],
    copy: [],
    error: null
};

const FETCH_POLLUTION_SUCCESS = 'FETCH_POLLUTION_SUCCESS';
const FETCH_POLLUTION_FAILURE = 'FETCH_POLLUTION_FAILURE';
const SET_DATA = 'SET_DATA';

export function reducer(state=initialState, action) {
    switch(action.type) {
        case FETCH_POLLUTION_SUCCESS:
            return {
                pollution: action.payload.pollution,
                filter: action.payload.pollution,
                copy: action.payload.pollution,
                error: null
            };
        case FETCH_POLLUTION_FAILURE:
            return {
                error: action.payload.error,
                pollution: [],
                filter: [],
                copy: []
            };

        case SET_DATA:
            var regEx = action.payload.filter;
            var copy = state.copy;
            var filter = state.copy;
            var state = filter.filter((item) => regEx.test(item.state));
            return {
                ...initialState,
                error: null,
                pollution: state,
                filter: filter,
                copy: copy
            }
        default:
            return state;
    }
}