import React, { Component } from 'react';
import {
  StyleSheet,
  Text,
  View
} from 'react-native';

const SERVER_URL = 'ws://localhost:3000/websocket';


class App extends Component {
  componentWillMount() {
    Meteor.connect(SERVER_URL);
  }

}

export default App;
