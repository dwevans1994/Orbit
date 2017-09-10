import React from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';
import CheckBox from 'react-native-checkbox-heaven';

export default class Gender extends React.Component {
    constructor(props) {
        super(props);
        this.state = { male_checked: true, female_checked: true, other_checked: true };
    }


    render() {
        return (
            <View style={{ top: 80, }}>
                <View>
                    <Text style={{ color: 'white', left: 40 }}>Select Gender</Text>
                </View>
                <View style={{ top: 25, flexDirection: 'row' }}><CheckBox propsname={this.state.checked}
                    checkedColor="#42b3f4"
                    uncheckedColor="#f44242"
                    iconName='matCircleEdge'
                    onChange={() => this.setState({ checked: !this.state.male_checked })} />
                    <Text style={{ color: 'white' }}>Male</Text>
                    <CheckBox
                        checkedColor="#42b3f4"
                        uncheckedColor="#f44242"
                        iconName='matCircleEdge'
                        onChange={() => 7} />
                    <Text style={{ color: 'white' }}>Female</Text>
                    <CheckBox
                        checkedColor="#42b3f4"
                        uncheckedColor="#f44242"
                        iconName='matCircleEdge'
                        onChange={() => this.setState({
                            checked: !this.state.other_checked,
                        })} />
                    <Text style={{ color: 'white' }}>Simon</Text>
                </View>
            </View>
        );
    }

}