// app/index.js
import React, { Component } from 'react';
import { View, Text } from 'react-native';
import Meteor, { createContainer } from 'react-native-meteor';
import {
  StyleSheet,
  Text,
  View
} from 'react-native';
import Meteor from 'react-native-meteor';

const SERVER_URL = 'http://localhost:3000/';

class App extends Component {
  componentWillMount() {
    Meteor.connect(SERVER_URL);

	  
  }

  // Removed for brevity
};

// Removed for brevity

export default App;
