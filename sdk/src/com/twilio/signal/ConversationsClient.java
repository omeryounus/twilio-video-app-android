package com.twilio.signal;

import java.util.Set;

import com.twilio.signal.impl.ConversationsClientImpl;

/**
 * An instance of ConversationsClient is an object that knows how to interface with Twilio SIGNAL Services.
 *
 * An ConversationsClient allows users to create or participate in conversations. An Android application should initialize a ConversationsClient
 * with a Capability Token to talk to Twilio SIGNAL services.
 *
 * @see ConversationsClientListener
 */


public interface ConversationsClient {

	/**
	 * Key into an Intent's extras data that points to a {@link ConversationsClientImpl} object.
	 */
	public static final String EXTRA_DEVICE = "com.twilio.signal.ConversationsClientImpl";

	/**
	 * Sets a new {@link ConversationsClientListener} object to respond to device events.
	 * 
	 * @param listener A {@link ConversationsClientListener}, or null
	 */
	public void setConversationsClientListener(ConversationsClientListener listener);

	/**
	 * Identity of this conversationsClient on the network for incoming calls.
	 *
	 * @return identity of this conversationsClient
 	 */
	public String getIdentity();

	/**
	 * Reflects current listening state of the conversations client
	 * 
	 * @return @return <code>true</code> if conversations client is listening, </code>false</code> otherwise.
 	 */
	public boolean isListening();

	/**
	 * Start listening for incoming Conversation.
	 * 
	 */
	public void listen();

	/**
	 * 
	 * Stop listening for incoming Conversations.
	 * 
	 */
	public void unlisten();

	/**
	 * Send an invitation to start a conversation with the following participants and local media configuration
	 * 
	 * @param participants Set of participant names as Strings
	 * @param localMedia Local Media you would like to use when setting up the new conversation
	 * @param conversationCallback The callback that will provide the conversation once it's been created
	 */
	public OutgoingInvite sendConversationInvite(Set<String> participants, LocalMedia localMedia, ConversationCallback conversationCallback);

	/**
	 * Releases resources associated with this ConversationsClient object.
	 * 
	 * Attempts to use this ConversationsClient object after disposal will result in an IllegalStateException.
	 */
	public void dispose();
	
	/**
	 * Set the audio output speaker for current client device.
	 * Bluetooth is currently not supported.
	 * In order to use volume up/down keys, you need to call 'setVolumeControlStream(AudioManager.STREAM_VOICE_CALL);' inside activity.
	 * 
	 * @param audioOutput that should be used by the system
	 */
	public void setAudioOutput(AudioOutput audioOutput);
	
	/**
	 * Audio output speaker for the current client device
	 * 
	 * @return audio output speaker
	 */
	public AudioOutput getAudioOutput();

}
